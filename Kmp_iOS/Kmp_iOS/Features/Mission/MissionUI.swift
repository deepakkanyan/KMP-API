//
//  MissionUI.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MissionUI: View {
    
    @ObservedObject var viewModel = MissionViewModel()
    
    var body: some View {
        Group {
            switch viewModel.missionResponse {
            case is MissionResponse.Loading:
                ProgressView()
            case let success as MissionResponse.Success:
                List(success.data) { missionInfo in
                    MissionCardView(missionInfo: missionInfo).listRowSeparator(.hidden)
                        .foregroundColor(.none)
                }.background(Color.clear).listStyle(PlainListStyle())
                
            case let error as MissionResponse.Error:
                Text("Error: \(error.e)")
            default:
                EmptyView()
            }
        }
        .onAppear {
            viewModel.fetchMissions()
        }.navigationTitle("Missions")
    }
}

struct MissionUI_Previews: PreviewProvider {
    static var previews: some View {
        MissionUI()
    }
}
