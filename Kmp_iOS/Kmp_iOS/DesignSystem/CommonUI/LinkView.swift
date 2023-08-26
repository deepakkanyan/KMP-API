//
//  LinkView.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 26/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

import SwiftUI

struct ClickableIconView: View {
    let icon: String
    let linkText: String?
    
    var body: some View {
       
   Image(systemName: icon).font(.largeTitle)
        .padding()
        .background(Color.gray.opacity(0.2))
        .cornerRadius(10)
        .onTapGesture {
            if let urlString = linkText, let url = URL(string: urlString) {
                            if UIApplication.shared.canOpenURL(url) {
                                UIApplication.shared.open(url, options: [:], completionHandler: nil)
                            }
                        }
        }
    }
}
 
