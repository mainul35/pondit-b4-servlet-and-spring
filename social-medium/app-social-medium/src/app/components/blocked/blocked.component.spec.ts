import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockedComponent } from './blocked.component';

describe('BlockedComponent', () => {
  let component: BlockedComponent;
  let fixture: ComponentFixture<BlockedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BlockedComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BlockedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
