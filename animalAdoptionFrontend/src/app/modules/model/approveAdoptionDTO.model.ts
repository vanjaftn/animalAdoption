export class ApproveAdoptionDTO {
    animalId: string = "";
    userId: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.animalId = obj.animalId;
            this.userId = obj.userId;
            
        }
    }
}