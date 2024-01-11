export class CreateUserDTO {
    userId: string = "";
    email: string = "";
    firstName: string = "";
    lastName: string = "";
    dateOfBirth !: Date;
    phoneNumber !: number;
    personalId !: number;

    public constructor(obj?: any) {
        if (obj) {
            this.email = obj.email;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.dateOfBirth = obj.dateOfBirth;
            this.phoneNumber = obj.phoneNumber;
            this.personalId = obj.personalId;
        }
    }
}