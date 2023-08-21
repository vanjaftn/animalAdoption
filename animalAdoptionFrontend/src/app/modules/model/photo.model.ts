export class Photo {
    photoId: string = "";
    animalId: string = "";
    photoURL: string = "";

    public constructor(obj?: any) {
        if (obj) {
            this.photoId = obj.photoId;
            this.animalId = obj.animalId;
            this.photoURL = obj.photoURL;
            
        }
    }
}