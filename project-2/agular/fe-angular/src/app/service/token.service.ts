import {Injectable} from '@angular/core';

const TOKEN_KEY = 'Token_key';
const NAME_KEY = 'Name_key';
const ROLE_KEY = 'Role_key';
const AVATAR_KEY = 'Avatar_key';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  private roles: Array<String> = [];

  constructor() {
  }

  public setToken(token: string) {
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return window.localStorage.getItem(TOKEN_KEY);
  }

  public setAvatar(avatar: string) {
    window.localStorage.removeItem(AVATAR_KEY);
    window.localStorage.setItem(AVATAR_KEY, avatar);
  }

  public getAvatar(): string {
    return window.localStorage.getItem(AVATAR_KEY);
  }

  public setName(name: string) {
    window.localStorage.removeItem(NAME_KEY);
    window.localStorage.setItem(NAME_KEY, name);
  }

  public getName(): string {
    return window.localStorage.getItem(NAME_KEY);
  }

  public setRole(roles: string[]) {
    window.localStorage.removeItem(ROLE_KEY);
    window.localStorage.setItem(ROLE_KEY, JSON.stringify(roles));
  }

  public getRole(): string[] {
    this.roles = [];
    // nếu có đăng nhập
    if (localStorage.getItem(TOKEN_KEY)) {
      JSON.parse(localStorage.getItem(ROLE_KEY)).forEach(role => {
        this.roles.push(role.authority); // authority dùng để lấy dữ liệu từ kiểu jon
      });
      // @ts-ignore
      return this.roles;
    }
  }

  public getLogout() {
    window.localStorage.clear();

  }
}
