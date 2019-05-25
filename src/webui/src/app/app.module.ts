import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {AppRoutingModule} from "./app.routing.module";
import {AppLayoutComponent} from "./_layout/app-layout/app-layout.component";
import {FooterComponent} from "./_layout/footer/footer.component";
import {HeaderComponent} from "./_layout/header/header.component";
import {SidebarComponent} from "./_layout/sidebar/sidebar.component";
import {BsDatepickerModule, BsDropdownModule, CollapseModule, ModalModule, PaginationModule} from "ngx-bootstrap";
import {ToastNoAnimation, ToastNoAnimationModule, ToastrModule} from "ngx-toastr";
import {ApiService} from "./service/api.service";
import {ProjectService} from "./service/shared/project.service";
import {IssueService} from "./service/shared/issue.service";
import {HttpClientModule} from "@angular/common/http";
import { NotfoundComponent } from './notfound/notfound.component';


@NgModule({
    declarations: [
        AppComponent,
        AppLayoutComponent,
        FooterComponent,
        HeaderComponent,
        SidebarComponent,
        NotfoundComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        CollapseModule.forRoot(),
        BsDropdownModule.forRoot(),
        ModalModule.forRoot(),
        PaginationModule.forRoot(),
        BsDatepickerModule.forRoot(),
        ToastNoAnimationModule,
        ToastrModule.forRoot({
            toastComponent: ToastNoAnimation,
            maxOpened: 1,
            autoDismiss: true
        }),
    ],
    providers: [ApiService, ProjectService, IssueService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
