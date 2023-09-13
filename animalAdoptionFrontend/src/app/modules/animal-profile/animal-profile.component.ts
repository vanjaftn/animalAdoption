import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { AnimalWithSubscription } from '../model/animal-with-subscription.model';
import { NewSubscription } from '../model/new-subscription.model';
import { AdoptionService } from '../service/adoption.service';
import { Adoption } from '../model/adoption.model';
import { VetService } from '../service/vet.service';
import { PhotoService } from '../service/photo.service';
import { Photo } from '../model/photo.model';
import { VideoService } from '../service/video.service';
import { Video } from '../model/video.model';
import { LostAndFoundService } from '../service/lostAndFound.service';
import { LostAndFoundPageComponent } from '../lost-and-found-page/lost-and-found-page.component';
import { LostAndFound } from '../model/lost-and-found.model';

@Component({
  selector: 'app-animal-profile',
  templateUrl: './animal-profile.component.html',
  styleUrls: ['./animal-profile.component.css']
})
export class AnimalProfileComponent {

  public selectedAnimalProfileId = localStorage.getItem('selectedAnimalProfileId')
  public selectedAnimalProfile : AnimalWithSubscription = new AnimalWithSubscription
  public userIsAdmin = localStorage.getItem('userIsAdmin')
  public userIsVet = localStorage.getItem('userIsVet')
  public adoption : Adoption = new Adoption
  public animalAdopted !: String
  public animalSterilized : string = ""
  public animalPhotos: Array<string> = new Array()
  public animalVideos: Array<string> = new Array()
  public profilePhoto: string = this.animalPhotos[0]
  public loggedInUserIsAdopter !: String
  public addNewPhotosButton : Boolean = false
  public deletePhotosButton : Boolean = false
  public selectedFile!: File;
  public selectedFiles: Array<File> = new Array()
  public fileURLs : Array<string> = new Array()
  public allAnimalTypes : Array<String> = new Array()
  public dob : String = ""
  public isLostAndFound : string = ""
  public isApproved : string = ""
  public lostOrFound : string = ""
  public lostAndFoundAnimal: LostAndFound = new LostAndFound
  
  constructor(private animalService: AnimalService, private subscriptionService: SubscriptionService,
    private adoptionService: AdoptionService, private vetService: VetService, private photoService: PhotoService,
    private videoService: VideoService , private lostAndFoundService: LostAndFoundService) { }
    
    ngOnInit(): void {

    this.read()
    this.readMedia()
    this.readLostAndFound()
  }

  public getDate(date : Date) {
    let day = date.getDate();
    let month = date.getMonth() + 1;
    let year = date.getFullYear();
    this.dob = day + '.' + month + '.' + year + '.'
  }

  read(){
    this.animalService.read(this.selectedAnimalProfileId!).subscribe((response: any) => {
      console.log(JSON.parse(response))
      this.selectedAnimalProfile = JSON.parse(response)

      this.getDate(new Date(this.selectedAnimalProfile.dateOfBirth))


      this.addSubscriptionStatus()
      this.setAdoptionStatus()
      this.setSterilizationStatus()
    }
   );
  }

  readMedia(){
    this.photoService.allAnimalPhotos(this.selectedAnimalProfileId!).subscribe((response: any) => {
      const allPhotos = JSON.parse(response)

      // @ts-ignore
      allPhotos.forEach(photo => {
        let photoURL : string
        photoURL ="\\assets\\images\\"+photo.photoURL
        this.animalPhotos.push(photoURL)
      });

      console.log(allPhotos)
    }
   );

   this.videoService.allAnimalVideos(this.selectedAnimalProfileId!).subscribe((response: any) => {
      const allVideos = JSON.parse(response)

      // @ts-ignore
      allVideos.forEach(video => {
        let videoURL : string
        videoURL ="\\assets\\images\\"+video.videoURL
        this.animalVideos.push(videoURL)
      });

      console.log(allVideos)
    }
  );
  }

  addSubscriptionStatus() {
    
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription

      this.subscriptionService.subscriptionExists(this.selectedAnimalProfile.animalId).subscribe((response: any) => {

        animalWithSubscription.animalId = this.selectedAnimalProfile.animalId
        animalWithSubscription.dateOfBirth = this.selectedAnimalProfile.dateOfBirth
        animalWithSubscription.name = this.selectedAnimalProfile.name
        animalWithSubscription.gender = this.selectedAnimalProfile.gender
        animalWithSubscription.location = this.selectedAnimalProfile.location
        animalWithSubscription.description = this.selectedAnimalProfile.description
        animalWithSubscription.chipNumber = this.selectedAnimalProfile.chipNumber
        animalWithSubscription.animalType = this.selectedAnimalProfile.animalType
        animalWithSubscription.size = this.selectedAnimalProfile.size
        animalWithSubscription.sterilized = this.selectedAnimalProfile.sterilized

        if(response == "false"){
          animalWithSubscription.subscription = false
        }
        if(response == "true"){
          animalWithSubscription.subscription = true
        }
        this.selectedAnimalProfile = animalWithSubscription
      })    
  }

  subscribe(){

    let subscription = new NewSubscription

    subscription.animalId = this.selectedAnimalProfile.animalId
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {

      window.location.reload()
    }
    );
  }

  unsubscribe(){

    this.subscriptionService.readByAnimalId(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
      let subscriptionId = JSON.parse(response).subscriptionId

      this.subscriptionService.unsubscribe(subscriptionId).subscribe((response: any) => {
  
      window.location.reload()

      }
      );
    });
  }
  
  delete(animalId : string){
    
    if(confirm("Are you sure you want to delete this animal?")) {
      this.animalService.delete(animalId).subscribe((response: any) => {
        console.log(response)
        
        window.location.href = '/unadopted-animals'
      });   
    }
  }

  setAdoptionStatus(){
    this.adoptionService.animalAdopted(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
      this.animalAdopted = response

      this.adoptionService.adoptionExists(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
        this.loggedInUserIsAdopter = response
        
      });
    });
  }

  setSterilizationStatus(){
    this.animalService.animalSterilized(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
      this.animalSterilized = response

      if(response == 'true'){
        this.animalSterilized = "Yes"
      }
      else{
        this.animalSterilized = "No"
      }
    });
  }

  adopt(){
    console.log(this.selectedAnimalProfile.animalId)

    this.adoption.adoptionDate = new Date
    this.adoption.adoptionStatus = ""
    this.adoption.animalId = this.selectedAnimalProfile.animalId
    this.adoption.userId = ""

    this.adoptionService.create(this.adoption).subscribe(() => {

      alert('You will be contacted by our admin as soon as possible via email');

      // window.location.href = '/login-user'
    },
    (error) => {
      alert("Your request filed");
      console.log(error);
    }
   );
  }

  adoptionRequestPage(){
    const animalId = this.selectedAnimalProfileId
    const adoptionRequsestURL = `adoption-request-page/${animalId}`;
    window.location.href = adoptionRequsestURL;  
  }

  animalVaccinesPage(){
    const animalId = this.selectedAnimalProfileId
    const adoptionRequsestURL = `animal-vaccines-page/${animalId}`;
    window.location.href = adoptionRequsestURL;  
  }

  animalIsSterilized(){
    this.vetService.animalIsSterilized(this.selectedAnimalProfile).subscribe((response: any) => {

      alert('You have checked this animal as sterilized');

      // window.location.href = '/login-user'
    },
    (error) => {
      alert("Failed");
      console.log(error);
    }
   );
  }
  
  addNewPhotoButtonChange(){
    this.addNewPhotosButton = true
  }

  deletePhotoButtonChange(){
    this.deletePhotosButton = true
  }

  uploadMedia(event: any){

    const selectedFiles: FileList = event.target.files;

    if (selectedFiles.length > 0) {
      for (let i = 0; i < selectedFiles.length; i++) {
        this.selectedFile = <File>event.target.files[i]
        console.log(this.selectedFile)
        
        this.selectedFiles.push(this.selectedFile)

      }
    }
  }

  addNewMedia() {
    this.selectedFiles.forEach(file => {
      const formData = new FormData();
  
      formData.append('image', file, file.name)

      let photo: Photo = new Photo
      photo.animalId = this.selectedAnimalProfileId!
      photo.photoURL = file.name

      let video: Video = new Video
      video.animalId = this.selectedAnimalProfileId!
      video.videoURL = file.name
    
      if(photo.photoURL.endsWith("mp4")){
        this.videoService.adopterAddVideos(video).subscribe()
      }
      else{
        this.photoService.adopterAddPhotos(photo).subscribe()
      }
      this.photoService.uploadMedia(formData).subscribe()
        this.fileURLs.push(file.name)
        this.addNewPhotosButton = true
        
      });
      alert('Successfully added media');
      window.location.reload()
  }

  update() {
    window.location.href = '/update-animal-page'
  }

  enlargeImage(imageSrc: string): void {
    const enlargedImage = document.getElementById('enlarged-image') as HTMLImageElement;
    enlargedImage.src = imageSrc;

    const overlay = document.querySelector('.enlarge-overlay') as HTMLElement;
    overlay.style.display = 'flex';
  }

  closeEnlarged(): void {
    const overlay = document.querySelector('.enlarge-overlay') as HTMLElement;
    overlay.style.display = 'none';
  }

  playVideo(media: any) {
    const videoElement = document.getElementById('enlarged-media') as HTMLVideoElement;
    videoElement.src = media.url;

    videoElement.muted = !videoElement.muted;
    videoElement.play();
  }

  readLostAndFound(){

    this.lostAndFoundService.lostAndFoundExists(this.selectedAnimalProfileId!).subscribe((response: any) => {
      this.isLostAndFound = response
      
      if(response === "true") {
        this.lostAndFoundService.readByAnimalId(this.selectedAnimalProfileId!).subscribe((response: any) => {
          this.lostAndFoundAnimal = response
          console.log(this.lostAndFoundAnimal)
          this.isApproved = JSON.parse(response).approved.toString()
          this.lostOrFound = JSON.parse(response).lostAndFoundStatus

          if( JSON.parse(response).lostAndFoundStatus == "LOST"){
            this.lostOrFound = "Lost"
          }
          if( JSON.parse(response).lostAndFoundStatus == "FOUND"){
            this.lostOrFound = "Found"
          }        
        });
      }
    });
  }

  approveLostAndFound(){
    console.log(this.lostAndFoundAnimal)

    this.lostAndFoundService.adminApproveLAF(this.lostAndFoundAnimal).subscribe((response: any) => {
      this.isLostAndFound = response
      console.log(this.isLostAndFound)

      alert('Successfully approved');


      // window.location.href = '/unadopted-animals'
    });
  }
}
