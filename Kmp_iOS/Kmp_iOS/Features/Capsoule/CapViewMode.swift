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
}