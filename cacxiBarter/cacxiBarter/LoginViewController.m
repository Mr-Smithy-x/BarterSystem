//
//  LoginViewController.m
//  cacxiBarter
//
//  Created by xbin on 5/2/15.
//  Copyright (c) 2015 XbinZhao. All rights reserved.
//

#import "LoginViewController.h"

@interface LoginViewController ()

@end

@implementation LoginViewController

@synthesize loginUserName, loginPassword;

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
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

- (IBAction)loginButton:(id)sender {
    
    NSMutableString * mtURL = [[NSMutableString alloc] initWithFormat:@"http://192.168.156.155/?u=%@&p=%@&t=%@", loginUserName.text, loginPassword.text, @"l"];
    
    [mtURL setString:[mtURL stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
    
    NSData * dataUrl = [NSData dataWithContentsOfURL:[NSURL URLWithString:mtURL]];
    
    NSMutableString *mtResult = [[NSMutableString alloc] initWithData:dataUrl encoding:NSUTF8StringEncoding];
    
    NSLog(@"PhP: %@", mtResult);
    
    NSRange range = [mtResult rangeOfString:@"true"];
    NSString *substring = [mtResult substringWithRange:range];
    if([substring  isEqual: @"true"]){
        NSLog(@"Login Successful");
        //[self performSegueWithIdentifier:@"logged" sender:self];
        UITabBarController *controller = [self.storyboard instantiateViewControllerWithIdentifier:@"DummyTab"];
        [self.navigationController pushViewController:controller animated:YES];
        //[controller setSelectedIndex:0];
    }
    else{
        NSLog(@"Login Fail");
    }
    //NSLog(@"%@", substring);
    
    /* =======
    NSRange range = [string rangeOfString:@"ipsum"];
    // {.location=6, .length=5}
    
    NSString *substring = [string substringWithRange:range];
    // @"ipsum"
    */
                       
    //NSString *test = [mtResult copy];
    
    //NSLog(@"%c",[test characterAtIndex:0]);
}
@end
