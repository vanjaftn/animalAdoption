import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginUserComponent } from './modules/login-user/login-user.component';
import { RegisterUserComponent } from './modules/register-user/register-user.component';
import { UnadoptedAnimalsPageComponent } from './modules/unadopted-animals-page/unadopted-animals-page.component';
import { AdoptedAnimalsPageComponent } from './modules/adopted-animals-page/adopted-animals-page.component';
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
import { ChangePasswordPageComponent } from './modules/change-password-page/change-password-page.component';
import { RegisterLostAndFoundComponent } from './modules/register-lost-and-found/register-lost-and-found.component';
import { LostAndFoundPageComponent } from './modules/lost-and-found-page/lost-and-found-page.component';
import { ApproveLostAndFoundPageComponent } from './modules/approve-lost-and-found-page/approve-lost-and-found-page.component';

const routes: Routes = [
  { path: 'login-user', component: LoginUserComponent},
  { path: 'register-user', component: RegisterUserComponent},
  { path: 'register-animal', component: RegisterAnimalComponent},
  { path: 'register-vet', component: RegisterVetComponent},
  { path: 'register-lost-and-found', component: RegisterLostAndFoundComponent},
  { path: 'unadopted-animals', component: UnadoptedAnimalsPageComponent},
  { path: 'adopted-animals', component: AdoptedAnimalsPageComponent},
  { path: 'subscribed-animals', component: SubscribedAnimalsPageComponent},
  { path: 'lost-and-found-animals', component: LostAndFoundPageComponent},
  { path: 'approve-lost-and-found-animals', component: ApproveLostAndFoundPageComponent},
  { path: 'animal-profile/:id', component: AnimalProfileComponent},
  { path: 'user-profile', component: UserProfileComponent},
  { path: 'adoption-request-page/:id', component: AdoptionRequestsPageComponent},
  { path: 'animal-vaccines-page/:id', component: AnimalVaccinesComponent},
  { path: 'create-vaccine-page', component: CreateVaccineComponent},
  { path: 'update-animal-page', component: UpdateAnimalPageComponent},
  { path: 'update-user-page', component: UpdateUserPageComponent},
  { path: 'change-password-page', component: ChangePasswordPageComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
