import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";

@Injectable({ providedIn: 'root' })
export class AuthGuard implements CanActivate {

    constructor(private router: Router) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        if (localStorage.getItem('currentUser')) {
            return true;
        }

        //localStorage da user yoksa login sayfasına yünlendirelecek. Uygulamada ki filter dır. session yoksa logine yonlendir.
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
        return false;
    }
}
