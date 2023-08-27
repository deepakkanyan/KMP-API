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
    
    @Published var missionResponse: KmpResponse<[MissionModel]>? // Nullable because Kotlin types are nullable
        
        init() {
            fetchMissions()
        }
        
        func fetchMissions() {
            GetMissionListUseCase().invoke { kmpResponse,arg ,arg\\\  in // Replace with your actual method
                
                if let successResponse = kmpResponse as? SharedCode.KmpResponse.Success {
                    self.missionResponse = .success(data: successResponse.data)
                }
                else if let errorResponse = kmpResponse as? SharedCode.KmpResponse.Error {
                    self.missionResponse = .error(exception: errorResponse.exception)
                }
                else if kmpResponse is SharedCode.KmpResponse.Loading {
                    self.missionResponse = .loading
                }
                else {
                    // handle unexpected cases
                }
            }
        }

    
    

    
    
    
    
}
