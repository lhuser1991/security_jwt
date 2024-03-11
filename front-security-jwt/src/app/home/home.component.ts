import { Component , OnInit} from '@angular/core';
import { UserService } from '../services/user/user.service';
import { User } from '../classes/user/user';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{

  homeTitle: string;
  user: User;

  constructor(private userService: UserService) {
    this.homeTitle = "";
    this.user = new User(0,"","","",0);
  }

  ngOnInit(): void {

  }

  function() {
    this.userService.getUserInformationFromCookie().subscribe(
      {
        next: resp => {
          this.user = resp;
          console.log(this.user);
        }
      }
    )
  }

}
