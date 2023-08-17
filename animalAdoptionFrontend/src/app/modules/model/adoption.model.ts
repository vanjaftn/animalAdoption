export class Adoption {
    adoptionId: string = "";
    animalId: string = "";
    userId: string = "";
    adoptionDate !: Date;
    adoptionStatus: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.adoptionId = obj.adoptionId;
            this.animalId = obj.animalId;
            this.userId = obj.userId;
            this.adoptionDate = obj.adoptionDate;
            this.adoptionStatus = obj.adoptionStatus;
            
        }
    }
}