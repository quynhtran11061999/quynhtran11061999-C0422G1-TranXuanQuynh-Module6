import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {NewsService} from '../../../service/news.service';
import {Router} from '@angular/router';
import {AngularFireStorage} from '@angular/fire/storage';
import {finalize} from 'rxjs/operators';

@Component({
  selector: 'app-news-create',
  templateUrl: './news-create.component.html',
  styleUrls: ['./news-create.component.css']
})
export class NewsCreateComponent implements OnInit {
  newsForm: FormGroup;
  img: any = '';
  submitter = false;

  constructor(private newsService: NewsService,
              private router: Router,
              @Inject(AngularFireStorage) private storage: AngularFireStorage
  ) {
  }

  ngOnInit(): void {
    this.newsForm = new FormGroup({
      title: new FormControl('',[Validators.required]),
      postingDay: new FormControl('',[Validators.required]),
      content: new FormControl('',Validators.required),
      imgUrl: new FormControl('',Validators.required),
    });
  }

  get title(){
    return this.newsForm.get('title');
  }

  uploadFile() {
    return new Promise((resolve, reject) => {
        const nameImg = Date.now() + this.img.name;
        const fileRef = this.storage.ref(nameImg);
        this.storage.upload(nameImg, this.img).snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe((url) => {
              this.newsForm.patchValue({img: url});
              resolve(true);
              this.newsForm.value.imgUrl = url;
            });
          })
        ).subscribe();
      }
    );
  }

  submit() {

    this.uploadFile().then(() => {
      this.submitter = true;
      console.log(this.newsForm.value);
      this.newsService.create(this.newsForm.value).subscribe(next => {
        alert('thành công');
      });
    });
  }

  showImg($event: any) {
    this.img = $event.target.files[0];
    console.log(this.img);
  }
}
