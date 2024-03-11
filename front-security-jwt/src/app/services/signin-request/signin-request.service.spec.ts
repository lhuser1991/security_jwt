import { TestBed } from '@angular/core/testing';

import { SigninRequestService } from './signin-request.service';

describe('SigninRequestService', () => {
  let service: SigninRequestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SigninRequestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
