export class UserWithDobDTO {
    userId: string = "";
    email: string = "";
    password: string = "";
    firstName: string = "";
    lastName: string = "";
    dateOfBirth !: Date;
    phoneNumber : string = "";
    personalId : string = "";
    dob: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.email = obj.email;
            this.password = obj.password;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.dateOfBirth = obj.dateOfBirth;
            this.phoneNumber = obj.phoneNumber;
            this.personalId = obj.personalId;
            this.dob = obj.dob;
        }
    }
}