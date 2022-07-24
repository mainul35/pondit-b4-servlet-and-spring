import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MutualTabsComponent } from './mutual-tabs.component';

describe('MutualTabsComponent', () => {
  let component: MutualTabsComponent;
  let fixture: ComponentFixture<MutualTabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MutualTabsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MutualTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
