//
//  TabItem.swift
//  Kmp_iOS
//
//  Created by Deepak Kanyan on 18/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct TabItem: View  {
    
    var title : String
    var image : String
    
    var body: some View {
        VStack {
            Image(systemName: image)
            Text(title)
      }
    }
}


struct TabItem_Previews: PreviewProvider {
    static var previews: some View {
        TabItem(title: "Deep", image: "ic_rocket")
    }
}


