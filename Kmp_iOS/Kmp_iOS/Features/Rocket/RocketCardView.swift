//
//  RocketCardView.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketCardView: View {
    var rocketInfo: RocketModel

    var body: some View {
        VStack(alignment: .leading) {
            rocketImage
            Spacer(minLength: 30)
            rocketInfoView
        }
        .background(Color("surface"))
        .cornerRadius(8)
        .shadow(radius: 2)
    }
    
    private var rocketImage: some View {
        AsyncImage(url: URL(string: rocketInfo.rocketsImages.first ?? ""), content: { image in
            image.resizable().aspectRatio(contentMode: .fill)
        }, placeholder: {
            Color.gray
        })
        .frame(maxWidth: .infinity, maxHeight: 220.0)
    }
    
    private var rocketInfoView: some View {
        VStack(alignment: .leading) {
            Text(rocketInfo.name).font(.body)
            Text(rocketInfo.company).font(.caption2)
            Text(rocketInfo.description_).font(.caption2)
        }
        .font(.footnote)
        .padding()
    }
}

