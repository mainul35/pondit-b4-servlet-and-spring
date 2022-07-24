import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrowserUsersComponent } from './browser-users.component';

describe('BrowserUsersComponent', () => {
  let component: BrowserUsersComponent;
  let fixture: ComponentFixture<BrowserUsersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrowserUsersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrowserUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
