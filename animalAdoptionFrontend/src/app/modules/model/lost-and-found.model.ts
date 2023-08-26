export class LostAndFound {
    lostAndFoundId : string = "";
    animalId : string = "";
    userId : string = "";
    lostAndFoundDate !: Date;
    lostAndFoundStatus: string = "";
    approved!: Boolean

    public constructor(obj?: any) {
        if (obj) {
            this.lostAndFoundId = obj.lostAndFoundId;
            this.animalId = obj.animalId;
            this.userId = obj.userId;
            this.lostAndFoundDate = obj.lostAndFoundDate;
            this.lostAndFoundStatus = obj.lostAndFoundStatus;
            this.approved = obj.approved;
        }
    }
}