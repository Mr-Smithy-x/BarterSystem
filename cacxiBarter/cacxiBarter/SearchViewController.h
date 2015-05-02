//
//  SearchViewController.h
//  cacxiBarter
//
//  Created by xbin on 5/2/15.
//  Copyright (c) 2015 XbinZhao. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface SearchViewController : UIViewController
@property (strong, nonatomic) IBOutlet UITextField *searchText;
- (IBAction)searchButton:(id)sender;
@property (strong, nonatomic) IBOutlet UITextView *showTextFromString;

@end
