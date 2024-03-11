export class User {

    id: number;
    firstname: string;
    secondname: string;
    email: string;
    idRole: number;

    constructor(
        id: number,
        firstname: string,
        secondname: string,
        email: string,
        idRole: number
    ) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.email = email;
        this.idRole = idRole;
    }
}
