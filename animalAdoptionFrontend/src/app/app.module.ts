import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { LoginUserComponent } from './modules/login-user/login-user.component';
import { RegisterUserComponent } from './modules/register-user/register-user.component';
import { UnadoptedAnimalsPageComponent } from './modules/unadopted-animals-page/unadopted-animals-page.component';
import { AdoptedAnimalsPageComponent } from './modules/adopted-animals-page/adopted-animals-page.component';
import { FormsModule } from '@angular/forms';
import { SubscribedAnimalsPageComponent } from './modules/subscribed-animals-page/subscribed-animals-page.component';
import { AnimalProfileComponent } from './modules/animal-profile/animal-profile.component';
import { UserProfileComponent } from './modules/user-profile/user-profile.component';
import { RegisterAnimalComponent } from './modules/register-animal/register-animal.component';
import { AdoptionRequestsPageComponent } from './modules/adoption-requests-page/adoption-requests-page.component';
import { RegisterVetComponent } from './modules/register-vet/register-vet.component';
import { AnimalVaccinesComponent } from './modules/animal-vaccines/animal-vaccines.component';
import { CreateVaccineComponent } from './modules/create-vaccine/create-vaccine.component';
import { UpdateAnimalPageComponent } from './modules/update-animal-page/update-animal-page.component';
import { UpdateUserPageComponent } from './modules/update-user-page/update-user-page.component';
import { NgxImageZoomModule } from 'ngx-image-zoom';
import { LightboxModule } from 'ngx-lightbox';
import { ChangePasswordPageComponent } from './modules/change-password-page/change-password-page.component';
import { RegisterLostAndFoundComponent } from './modules/register-lost-and-found/register-lost-and-found.component';
import { LostAndFoundPageComponent } from './modules/lost-and-found-page/lost-and-found-page.component';
import { ApproveLostAndFoundPageComponent } from './modules/approve-lost-and-found-page/approve-lost-and-found-page.component';
import { LostPageComponent } from './modules/lost-page/lost-page.component';
import { FoundPageComponent } from './modules/found-page/found-page.component';
import { MyAdoptedAnimalsComponent } from './modules/my-adopted-animals/my-adopted-animals.component';
import { ForgotPasswordPageComponent } from './modules/forgot-password-page/forgot-password-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginUserComponent,
    RegisterUserComponent,
    UnadoptedAnimalsPageComponent,
    AdoptedAnimalsPageComponent,
    SubscribedAnimalsPageComponent,
    AnimalProfileComponent,
    UserProfileComponent,
    RegisterAnimalComponent,
    AdoptionRequestsPageComponent,
    RegisterVetComponent,
    AnimalVaccinesComponent,
    CreateVaccineComponent,
    UpdateAnimalPageComponent,
    UpdateUserPageComponent,
    ChangePasswordPageComponent,
    RegisterLostAndFoundComponent,
    LostAndFoundPageComponent,
    ApproveLostAndFoundPageComponent,
    LostPageComponent,
    FoundPageComponent,
    MyAdoptedAnimalsComponent,
    ForgotPasswordPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxImageZoomModule,
    LightboxModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
