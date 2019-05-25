import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ProjectComponent} from './project.component';
import {ProjectRoutingModule} from "./project.routing.module";
import {ProjectService} from "../../service/shared/project.service";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";

@NgModule({
    imports: [
        CommonModule,
        ProjectRoutingModule,
        NgxDatatableModule
    ],
    providers: [ProjectService],
    declarations: [ProjectComponent]
})
export class ProjectModule {
}
