//
//  RocketViewMode.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared


class RocketViewModel: ObservableObject {
    
    @Published var rocketResponse: RocketResponse = .Loading.shared
    
    init() {
        fetchRockets()
    }
    
    func fetchRockets() {
        GetRocketListUseCase().invoke { response, error in
            
            if let successResponse = response as? RocketResponse.Success {
                self.rocketResponse = .Success(data: successResponse.data)
            }
             else if let error = error as? RocketResponse.Error {
                self.rocketResponse = .Error(e: error.e)
            }
             else {
                self.rocketResponse = .Loading.shared
            }
        }
    }


    
}
