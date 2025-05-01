import React, { useEffect, useState } from 'react'

function Actor() {
    const [data, setData] =useState([]);
    useEffect(()=>{
        fetch('http://localhost:8082/SpringBootRest_APIProj_App/actor-api/get-all-actors')
        .then((res)=>res.json())
        .then((data)=>setData(data));
    },[])
  return (
    <div className="p-6 bg-gray-100 min-h-screen">
  <h2 className="text-3xl font-bold mb-6 text-center text-gray-800">Actor Data</h2>

  <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
    {data.map((actor, index) => (
      <div
        key={index}
        className="bg-white shadow-lg rounded-2xl overflow-hidden border border-gray-200"
      >
        <img
          src={`https://picsum.photos/seed/${actor.aid}/300/200`}
          alt={actor.aname}
          className="w-full h-48 object-cover"
        />

        <div className="p-4">
          <h3 className="text-xl font-semibold text-gray-800 mb-2">{actor.aname}</h3>

          <p className="text-sm text-gray-600"><strong>ID:</strong> {actor.aid}</p>
          <p className="text-sm text-gray-600"><strong>Category:</strong> {actor.category}</p>
          <p className="text-sm text-gray-600"><strong>Fee:</strong> ₹{actor.fee}</p>
          <p className="text-sm text-gray-600"><strong>Industry:</strong> {actor.industry}</p>
          <p className="text-sm text-gray-600"><strong>DOB:</strong> {actor.dob}</p>
        </div>
      </div>
    ))}
  </div>
</div>

  )
}

export default Actor