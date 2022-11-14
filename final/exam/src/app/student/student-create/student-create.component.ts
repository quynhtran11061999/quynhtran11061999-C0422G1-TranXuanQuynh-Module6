import {Component, OnInit} from '@angular/core';
import {Classes} from "../../../model/classes";
import {StudentService} from "../../../service/student.service";
import {ClassesService} from "../../../service/classes.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  classes: Classes[]
  studentForm: FormGroup = new FormGroup({
    id: new FormControl(),
    classes: new FormControl('',[Validators.required]),
    email: new FormControl('',[Validators.required,Validators.email]),
    name: new FormControl('',[Validators.required,Validators.pattern("^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]" +
      "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ]" +
      "[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ]" +
      "[a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$")]),
    phone: new FormControl('',[Validators.required,Validators.pattern('^\\+\\((84)\\)\\d{8}$')]),
    dateOfBirth: new FormControl('',[Validators.required]),
    citizenIdentification: new FormControl('',[Validators.required])
  })

  constructor(private studentService: StudentService, private classesService: ClassesService, private router: Router) {
  }

  ngOnInit(): void {
    this.classesService.getAll().subscribe(next => this.classes = next)
  }


  submit() {
    const student = this.studentForm.value;
    this.studentService.create(student).subscribe(next => {
      Swal.fire(
        'Thông báo!',
        'Thêm mới học viên thành công',
        'success'
      )
      this.router.navigateByUrl("/studentList")
    })
  }
}
