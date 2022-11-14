import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get("http://localhost:8080/studentRest/listStudent");
  }

  findById(id: number) {
    return this.http.get("http://localhost:8080/studentRest/listStudent/" + id);
  }

  create(student) {
    return this.http.post("http://localhost:8080/studentRest/create", student);
  }
}
