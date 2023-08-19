//
//  DashboardView.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct DashboardView: View {
    @State private var selectedTab = 0
    
       var body: some View {
           
           TabView(selection: $selectedTab) {
            
               RocketView()
                   .tabItem {
                       Label("Rocket", systemImage : "airplane.circle.fill")
                       //TabItem(title: "Rocket", image: "ic_rocket")
                   }
                   .tag(0)

               MissionUI()
                   .tabItem {
                       TabItem(title: "Mission", image: "target")
                   }
                   .tag(1)

               CapsuleUI()
                   .tabItem {
                       TabItem(title: "Capsule", image: "capsule.lefthalf.filled")
                   }
                   .tag(2)
           }
       }
}

struct DashboardView_Previews: PreviewProvider {
    static var previews: some View {
        DashboardView()
    }
}
