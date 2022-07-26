import { TestBed } from '@angular/core/testing';

import { UserConnectionService } from './user-connection.service';

describe('UserConnectionService', () => {
  let service: UserConnectionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserConnectionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
