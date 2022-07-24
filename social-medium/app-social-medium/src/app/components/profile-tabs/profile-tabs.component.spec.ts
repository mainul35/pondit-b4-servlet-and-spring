import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileTabsComponent } from './profile-tabs.component';

describe('ProfileTabsComponent', () => {
  let component: ProfileTabsComponent;
  let fixture: ComponentFixture<ProfileTabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileTabsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
