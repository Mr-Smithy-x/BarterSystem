//
//  RegisterViewController.h
//  cacxiBarter
//
//  Created by xbin on 5/2/15.
//  Copyright (c) 2015 XbinZhao. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface RegisterViewController : UIViewController
@property (strong, nonatomic) IBOutlet UITextField *userName;
@property (strong, nonatomic) IBOutlet UITextField *passWord;
@property (strong, nonatomic) IBOutlet UITextField *email;
@property (strong, nonatomic) IBOutlet UITextField *age;

// t = register(r) or login(l)
// @property (strong, nonatomic) IBOutlet UITextField *t;

- (IBAction)reg:(id)sender;


@end
