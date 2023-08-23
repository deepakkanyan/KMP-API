//
//  RocketView.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RocketView: View {
    
    @ObservedObject var viewModel = RocketViewModel()
    
    var body: some View {
        
        Group {
            switch viewModel.rocketResponse {
            case is RocketResponse.Loading:
                ProgressView()
            case let success as RocketResponse.Success:
                
                List(success.data) { rocket in
                    RocketCardView(rocketInfo: rocket).listRowSeparator(.hidden)
                        .foregroundColor(.none)
                }.background(Color.clear).listStyle(PlainListStyle())
                
            case let error as RocketResponse.Error:
                Text("Error: \(error.e)")
            default:
                EmptyView()
            }
        }
        .onAppear {
            viewModel.fetchRockets()
        }.navigationTitle("Rockets")
    }
}


struct RocketView_Previews: PreviewProvider {
    static var previews: some View {
        RocketView()
    }
}
