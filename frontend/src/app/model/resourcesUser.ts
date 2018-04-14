/**
 * H2MS API
 * API for interacting with the H2MS backend.
 *
 * OpenAPI spec version: 1.0
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

import { Link } from './link';
import { User } from './user';


export interface ResourcesUser {
    _embedded?: {
        users: Array<User>;
    };
    _links?: Array<Link>;
    page?: object;
}
