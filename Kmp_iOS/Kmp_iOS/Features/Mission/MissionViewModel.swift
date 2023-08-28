//
//  MissionViewModel.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 23/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


class MissionViewModel : ObservableObject{
    
    @Published var missionResponse: MissionResponse = .Loading.shared
        
        init() {
            fetchMissions()
        }
        
    
        func fetchMissions() {
            GetMissionListUseCase().invoke { response, error in
                
                if let successResponse = response as? MissionResponse.Success {
                    self.missionResponse = .Success(data: successResponse.data)
                }
                 else if let error = error as? MissionResponse.Error {
                    self.missionResponse = .Error(e: error.e)
                }
                 else {
                    self.missionResponse = .Loading.shared
                }
            }
        }
}



extension MissionModel: Identifiable {
    public var id: String {
        return "\(missionId)"
    }
}
