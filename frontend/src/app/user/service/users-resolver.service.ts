import {ActivatedRouteSnapshot, Resolve, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {UserEntityService} from '../../index';
import {Observable} from 'rxjs/Observable';
import {AuthService} from '../../auth/auth.service';

@Injectable()
export class UsersResolverService implements Resolve<any> {
    constructor(private userService: UserEntityService,
                private authService: AuthService) { }

    resolve(route: ActivatedRouteSnapshot, rstate: RouterStateSnapshot): Observable<any> {
        // Get 50 users
        // TODO: figure out how paging is going to work... and how many to get initially
        if (!this.authService.isLoggedIn()) {
            return Observable.of([]);
        }
        return this.userService.findAllUserUsingGET(undefined, '50', undefined);
    }
}
