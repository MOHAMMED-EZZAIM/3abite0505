import { Component } from '@angular/core';
import {RedevableAdminService} from "../../shared/service/admin/commun/RedevableAdmin.service";

@Component({
  selector: 'app-list-redevable',
  templateUrl: './list-redevable.component.html',
  styleUrls: ['./list-redevable.component.scss']
})
export class ListRedevableComponent {

    constructor(private service:RedevableAdminService) {
        this.service.findAll().subscribe(
            {
                next:data=>{
                    console.log(data)
                }
            }
        )
    }
}
