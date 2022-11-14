import {Component, OnInit} from '@angular/core';
import {Student} from "../../../model/student";
import {StudentService} from "../../../service/student.service";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students: Student[] = [];
  student1: Student

  constructor(private studentService: StudentService) {
  }

  ngOnInit(): void {
    this.getAll()
  }

  getAll() {
    this.studentService.getAll().subscribe(next => {
      this.students = next;
    })
  }

  detail(student: Student) {
    this.student1 = student
  }
}
