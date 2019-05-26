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
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {NotfoundComponent} from './notfound/notfound.component';
import {AuthenticationService} from "./security/authentication.service";
import {AuthGuard} from "./security/auth.guard";
import {JwtInterceptor} from "./security/jwt.interceptor";
import {ErrorInterceptor} from "./security/authentication.interceptor";
import { LoginComponent } from './login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
    declarations: [
        AppComponent,
        AppLayoutComponent,
        FooterComponent,
        HeaderComponent,
        SidebarComponent,
        NotfoundComponent,
        LoginComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
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
    providers: [ApiService,
        ProjectService,
        IssueService,
        AuthenticationService,
        AuthGuard,
        {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
        {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
