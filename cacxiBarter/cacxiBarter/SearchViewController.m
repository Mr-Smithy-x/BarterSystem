//
//  SearchViewController.m
//  cacxiBarter
//
//  Created by xbin on 5/2/15.
//  Copyright (c) 2015 XbinZhao. All rights reserved.
//

#import "SearchViewController.h"

@interface SearchViewController ()

@end

@implementation SearchViewController

@synthesize searchText, showTextFromString;

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



- (IBAction)searchButton:(id)sender {
    //NSString* s = @"Hello world";
    //self.showTextFromString.text = s;
    
    NSMutableString * mtURL = [[NSMutableString alloc] initWithFormat:@"http://192.168.156.155/?t=%@&item=%@", @"search", searchText.text];
    
    [mtURL setString:[mtURL stringByAddingPercentEscapesUsingEncoding:NSUTF8StringEncoding]];
    
    NSData * dataUrl = [NSData dataWithContentsOfURL:[NSURL URLWithString:mtURL]];
    
    NSMutableString *mtResult = [[NSMutableString alloc] initWithData:dataUrl encoding:NSUTF8StringEncoding];
    
    self.showTextFromString.text = mtResult;
}
@end
