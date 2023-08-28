//
//  MissionCardView.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 23/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MissionCardView: View {
    
    var missionInfo: MissionModel

    var body: some View {
        VStack(alignment: .trailing) {
        VStack(alignment: .leading,spacing: 10){
           Text(missionInfo.missionName).font(.body)
           Text(missionInfo.description_).font(.caption2)
            linkRow
            }.padding()
        }
        .background(Color.surface)
        .cornerRadius(8)
        .shadow(radius: 2)
    }
    
    
    private var linkRow: some View {
    
        HStack(spacing: 15){
            ClickableIconView(icon: "info.circle.fill", linkText:  missionInfo.website)
            ClickableIconView(icon: "person.circle.fill", linkText:  missionInfo.website)
            ClickableIconView(icon: "house.circle.fill", linkText:  missionInfo.website)
        }
    }
}

