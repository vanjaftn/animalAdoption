export class CreateVet {
    vetId: string = "";
    userId: string = "";
    email: string = "";
    password: string = "";
    firstName: string = "";
    lastName: string = "";
    dateOfBirth!: Date;
    phoneNumber: string = "";
    personalId: string = "";
    ordination: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.email = obj.email;
            this.userId = obj.userId;
            this.password = obj.password;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.dateOfBirth = obj.dateOfBirth;
            this.vetId = obj.vetId;
            this.phoneNumber = obj.phoneNumber;
            this.personalId = obj.personalId;
            this.ordination = obj.ordination;
        }
    }
}