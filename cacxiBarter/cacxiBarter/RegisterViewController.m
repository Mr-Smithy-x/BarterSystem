//
//  RegisterViewController.m
//  cacxiBarter
//
//  Created by xbin on 5/2/15.
//  Copyright (c) 2015 XbinZhao. All rights reserved.
//

#import "RegisterViewController.h"

@interface RegisterViewController ()

@end

@implementation RegisterViewController

@synthesize userName, passWord, email, age;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void) viewDidUnload {
    
    [self setUserName:nil];
    [self setPassWord:nil];
    [self setEmail:nil];
    [self setAge:nil];
    //[self setT:nil];
    
    //self.t.text = @"r";
    //NSLog(@"%@", t.text);
    
    [super viewDidUnload];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

- (IBAction)reg:(id)sender {

    NSMutableString * mtURL = [[NSMutableString alloc] initWithFormat:@"http://192.168.156.155/?u=%@&p=%@&e=%@&a=%@&t=%@", userName.text, passWord.text, email.text, age.text, @"r"];
    
    [mtURL setString:[mtURL stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
    
    NSData * dataUrl = [NSData dataWithContentsOfURL:[NSURL URLWithString:mtURL]];
    
    NSMutableString *mtResult = [[NSMutableString alloc] initWithData:dataUrl encoding:NSUTF8StringEncoding];
    
    NSLog(@"PhP: %@", mtResult);
    
    /*
    NSRange range = [mtResult rangeOfString:@"success"];
    NSString *substring = [mtResult substringWithRange:range];
    if([substring  isEqual: @"success"]){
        NSLog(@"Register Successful");
     
        UIAlertView *success = [[UIAlertView alloc] initWithTitle:@"Success" message:@"You have registered a new user" delegate:self cancelButtonTitle:@"OK" otherButtonTitles: nil];
        [success show];
        
        UITabBarController *controller = [self.storyboard instantiateViewControllerWithIdentifier:@"DummyTab"];
        [self.navigationController pushViewController:controller animated:YES];
        //[controller setSelectedIndex:0];
     
    }
    else{
        NSLog(@"Login Fail");
    }*/
    
    
    //NSString *tmpString = [mtResult substringFromIndex:5];
    //NSString *immutableString = [NSString stringWithString:mtResult];
    //NSLog(@"sub string: %@", immutableString);
}
@end
