import { TestBed } from '@angular/core/testing';

import { SigninResponseService } from './signin-response.service';

describe('SigninResponseService', () => {
  let service: SigninResponseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SigninResponseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
