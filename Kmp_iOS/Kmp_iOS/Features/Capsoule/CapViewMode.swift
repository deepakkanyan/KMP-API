//
//  CapViewMode.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 28/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class CapViewModel : ObservableObject{
    @Published var capResponse: CapResponse = .Loading.shared
    
    
    init() {
        fetchCap()
    }
    

    func fetchCap() {
        GetAllCap().invoke { response, error in
            
            if let successResponse = response as? CapResponse.Success {
                self.capResponse = .Success(data: successResponse.data)
            }
             else if let error = error as? CapResponse.Error {
                self.capResponse = .Error(e: error.e)
            }
             else {
                self.capResponse = .Loading.shared
            }
        }
    }
    
}

extension CapModel: Identifiable {
    public var idd: String {
        return "\(id)"
    }
}
