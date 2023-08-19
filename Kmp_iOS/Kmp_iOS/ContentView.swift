import SwiftUI
import shared

struct ContentView: View {

    @State private var count: Int = 0
    
    @State private var list : [RocketModel] = []
    
    let greet = Greeting().greet()
    let countCase = GetSumOfTwoUseCase(repoImpl: CountRepoImpl())


    var body: some View {
        
        VStack{

            Text("\(count)")
            
        
        Button("Hello"){
            loadData()
            loadRocket()
        }
            List(list){ rocket in
                    Text(rocket.company)
                    
           
      }
        }
            
        }
    
    func loadData() {
        countCase.invoke(a:  Int32(Int.random(in: 10..<50)), b:  Int32(Int.random(in: 100..<500))) { value, error in
            count = value?.intValue ?? 0
        }
    }
    
    func loadRocket()  {
        GetRocketListUseCase().invoke { rocketList, error in
          //  list = rocketList ?? []
        }
    }
}


extension RocketModel: Identifiable {
    public var id: String {
        return "\(name)-\(country)-\(company)"
    }
}


