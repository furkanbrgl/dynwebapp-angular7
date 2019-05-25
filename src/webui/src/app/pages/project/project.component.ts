import {Component, OnInit} from '@angular/core';
import {ProjectService} from "../../service/shared/project.service";
import {Project} from "../../common/project.model";
import {Page} from "../../common/page";

@Component({
    selector: 'app-project',
    templateUrl: './project.component.html',
    styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {

    page = new Page();
    cols = [
        {prop:'id',name:'No'},
        {prop:'projectName',name:'Project Name',sortable:false},
        {prop:'projectCode', name:'Project Code',sortable:false}];
    rows = [];

    constructor(private projectService: ProjectService) {

    }

    ngOnInit() {
        //Sayfa ilk load oldugunda
        this.setPage({offset: 0});
    }



    setPage(pageInfo){
        this.page.number = pageInfo.offset;
        this.projectService.getAll(this.page).subscribe(pagedData => {
            this.page.size = pagedData.size;
            this.page.number = pagedData.page;
            this.page.totalElements = pagedData.totalElements;
            this.rows = pagedData.content;
        });
    }
}