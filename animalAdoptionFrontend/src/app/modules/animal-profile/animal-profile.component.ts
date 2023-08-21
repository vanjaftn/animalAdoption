import { Component } from '@angular/core';
import { AnimalService } from '../service/animal.service';
import { SubscriptionService } from '../service/subscription.service';
import { AnimalWithSubscription } from '../model/animalWithSubscription.model';
import { NewSubscription } from '../model/newSubscription.model';
import { AdoptionService } from '../service/adoption.service';
import { Adoption } from '../model/adoption.model';
import { VetService } from '../service/vet.service';
import { PhotoService } from '../service/photo.service';
import { Photo } from '../model/photo.model';

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
  public profilePhoto: string = this.animalPhotos[0]
  public loggedInUserIsAdopter !: String
  public addNewPhotosButton : Boolean = false
  selectedFile!: File;
  selectedFiles: Array<File> = new Array()
  fileURLs : Array<string> = new Array()
  allAnimalTypes : Array<String> = new Array()
  public dob : String = ""
  
  constructor(private animalService: AnimalService, private subscriptionService: SubscriptionService,
    private adoptionService: AdoptionService, private vetService: VetService, private photoService: PhotoService) { }
    
    ngOnInit(): void {

    this.read()
    this.readPhotos()
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

  readPhotos(){
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
  }

  addSubscriptionStatus() {
    
      let animalWithSubscription : AnimalWithSubscription = new AnimalWithSubscription

      this.subscriptionService.subscriptionExists(this.selectedAnimalProfile.animalId).subscribe((response: any) => {

        // console.log(animalWithSubscription)

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
    // subscription.userId = localStorage.getItem('loggedUserEmail')
    this.subscriptionService.subscribe(subscription).subscribe((response: any) => {

      // alert('Successfully registered');

      window.location.reload()
    }
    );
  }

  unsubscribe(){

    this.subscriptionService.readByAnimalId(this.selectedAnimalProfile.animalId).subscribe((response: any) => {
      let subscriptionId = JSON.parse(response).subscriptionId

      this.subscriptionService.unsubscribe(subscriptionId).subscribe((response: any) => {
  
        // alert('Successfully registered');
  
      window.location.reload()

      }
      );
    });
  }
  
  delete(animalId : string){
    
    if(confirm("Are you sure to delete this animal?")) {
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

    this.adoptionService.create(this.adoption).subscribe((response: any) => {

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

  uploadPhoto(event: any){

    const selectedFiles: FileList = event.target.files;

    console.log(selectedFiles)

    if (selectedFiles.length > 0) {
      for (let i = 0; i < selectedFiles.length; i++) {
        this.selectedFile = <File>event.target.files[i]
        console.log(this.selectedFile)
        
        this.selectedFiles.push(this.selectedFile)

      }
    }
  }

  addNewPhotos() {

    this.selectedFiles.forEach(file => {
      const formData = new FormData();
  
      formData.append('image', file, file.name)
    
      console.log(file) 

      let photo: Photo = new Photo
      photo.animalId = this.selectedAnimalProfileId!
      photo.photoURL = file.name
    
      this.photoService.adopterAddPhotos(photo).subscribe(response=>{
        console.log(response)
  
      })
      this.photoService.uploadPhoto(formData).subscribe(response=>{
        console.log(response)
  
      })
        this.fileURLs.push(file.name)
  
        console.log(this.fileURLs)
        this.addNewPhotosButton = true
        
      });
      alert('Succesfully added photos');
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
}
