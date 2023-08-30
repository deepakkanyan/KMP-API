//
//  CapsuleUI.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct CapsuleUI: View {
    
    @ObservedObject var viewModel = CapViewModel()
    
    var body: some View {
         
        Group {
            switch viewModel.capResponse {
            case is CapResponse.Loading:
                ProgressView()
            case let success as CapResponse.Success:
                List(success.data) { capInfo in
                    CapCardView(capInfo: capInfo).listRowSeparator(.hidden)
                        .foregroundColor(.none)
                }.background(Color.clear).listStyle(PlainListStyle())
                
            case let error as CapResponse.Error:
                Text("Error: \(error.e)")
            default:
                EmptyView()
            }
        }
        .onAppear {
            viewModel.fetchCap()
        }.navigationTitle("Missions")
    }
}

struct CapsuleUI_Previews: PreviewProvider {
    static var previews: some View {
        CapsuleUI()
    }
}


