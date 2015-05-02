//
//  LoginViewController.h
//  cacxiBarter
//
//  Created by xbin on 5/2/15.
//  Copyright (c) 2015 XbinZhao. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface LoginViewController : UIViewController
@property (strong, nonatomic) IBOutlet UITextField *loginUserName;
@property (strong, nonatomic) IBOutlet UITextField *loginPassword;
- (IBAction)loginButton:(id)sender;

@end
