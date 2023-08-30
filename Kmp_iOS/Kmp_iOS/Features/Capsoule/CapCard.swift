//
//  CapCard.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 30/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CapCardView: View {
    
    var capInfo: CapModel

    var body: some View {
    
        VStack(alignment: .leading){
            Text(capInfo.serial).font(.body).font(.title2).frame(maxWidth: .infinity, alignment: .leading)
            Text(capInfo.status.uppercased()).font(.caption2).frame(maxWidth: .infinity, alignment: .leading)
            Text(capInfo.lastUpdate ?? "").font(.caption2).padding(.top, 5).frame(maxWidth: .infinity, alignment: .leading)
            }
        .padding()
        .frame(maxWidth: .infinity)
        .background(Color.surface)
        .cornerRadius(4)
        .shadow(radius: 2)
       
    }
    
   
}

